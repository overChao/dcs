package com.crodi.initiator.map;

import com.crodi.model.graph.Map;
import com.crodi.model.graph.Node;
import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: crodi.zhang
 * @Date: 2026/9/7 15:30
 * @Description: TODO
 **/


@Service
public class MapInitService {


    public void initMap(int level, Map map,  MapConfig config, List<MapLimit> limits) {


        int xMin = 1;
        int xMax = 54;

        int yMin = 1;
        int yMax = 19;


        List<Node> nodes = Lists.newArrayList();

        for (int i = xMin; i <= xMax; i++) {
            for (int j = yMin; j <= yMax; j++) {
                Node node = new Node(map.getWarehouseId(), map.getMapCode(), i, j, level);
                nodes.add(node);
            }
        }




    }



    private static Node createNode(String warehouseId, String mapCode, String nodeType, int x, int y, int z, int level) {


        Node node = new Node();

        node.setWarehouseId(warehouseId);
        node.setMapCode(mapCode);
    
        node.setNodeType(nodeType);

        node.setX(x);
        node.setY(y);
        node.setZ(z);
        node.setLevelNo(level);
        node.setCowNo(x);
        node.setColNo(y);
        node.setColNo(z);
        node.setDeviceTypes(List.of("1", "2", "3"));

        return node;

    }




}


@Data
class MapConfig {

    private int xMin;

    private int xMax;

    private int yMin;

    private int yMax;

}


@Data
class MapLimit {

    private int xStart;

    private int xEnd;

    private int yStart;

    private int yEnd;
}





