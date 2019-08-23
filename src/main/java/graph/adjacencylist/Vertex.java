package graph.adjacencylist;

import lombok.Data;

/**
 * 顶点结构
 */
@Data
public class Vertex {
    //存放点信息
    public int data;
    //与该点邻接的第一个边节点
    public Edge firstEdge;
}
