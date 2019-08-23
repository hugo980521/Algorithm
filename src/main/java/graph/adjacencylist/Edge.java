package graph.adjacencylist;

import lombok.Data;

/**
 * 边节点
 */
@Data
public class Edge {
    //对应的点下表
    public int vertexId;
    //边的权重
    public int weight;
    //下一个边节点
    public Edge next;
}
