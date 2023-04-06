/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author xblong
 */
public class ArrayNode extends Node implements Iterable<Node> {
    private final List<Node> nodeList;
    public ArrayNode() {
        nodeList = new ArrayList<>();
    }
    public void add(Node node) {
        nodeList.add(node);
    }

    public int size() {
        return nodeList.size();
    }

    @Override
    public Iterator<Node> iterator() {
        return nodeList.iterator();
    }
}

