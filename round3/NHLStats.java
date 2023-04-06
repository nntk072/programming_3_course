import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;

public class NHLStats {
    private static String readCommand(BufferedReader input) throws IOException {
    System.out.print("Enter commands: ");
        return input.readLine();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String cmd;
        ArrayList<String> allPlayers = new ArrayList<>();
        HashMap<String, ArrayList<String>> teams = new HashMap<>();
        HashMap<String, Integer> countryStats = new HashMap<>();
        while(!"quit".equals(cmd = readCommand(input))) {
            //read filename: read NHL data file
            String[] cmdParts = cmd.split("\\s+");
            if(cmdParts.length == 2 && "read".equals(cmdParts[0])) {
                try(var file = new BufferedReader(new FileReader(cmdParts[1]))) {
                    String row;
                    while((row = file.readLine()) != null) {
                        String[] cols = row.split(",");
                        if(cols.length == 25) {
                            String team = cols[3];
                            String player = cols[6] + ", " + cols[5];
                            String country = cols[13];
                            ArrayList<String> teamPlayers = teams.get(team);
                            if (teamPlayers == null) {
                                teamPlayers = new ArrayList<>();
                                teams.put(team, teamPlayers);
                            }
                            teamPlayers.add(player);
                            allPlayers.add(player);
                            int count = 1;
                            if(countryStats.containsKey(country)) 
                            {
                                count += countryStats.get(country);
                            }
                            countryStats.put(country, count);

                            //System.out.println(team + " " + player + " " + country);
                        }
                    }
                        
                }
            }
            else if("teams".equals(cmd)) {
            }


            //teams: lists all teams
                    
            //teams with players: list teams and their players
            //players: list all players
            //countries: lists countries with their player counts
            // countries by count: lists countries ordered by player count
        
        }
    }
}
