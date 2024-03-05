//package trash;
//
//import application.Matrix;
//import trash.AdjacencyMatrix;
//
//class IncidenceMatrix extends Matrix {
//    // Constructors
//    public IncidenceMatrix() {}
//
//    public IncidenceMatrix(int v, int h) {
//        super(v, h);
//    }
//
//    public IncidenceMatrix(int[][] matrix) {
//        super(matrix);
//    }
//
//    // Methods
//    public AdjacencyMatrix toAdjacencyMatrix () {
//        Matrix matrix = Matrix.transpose(this);
//        return matrix;
//
////        int[] setOfSums = new int[matrix.getH()];
////        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(matrix.getH());
////
////        for (int i = 0; i < matrix.getH(); i++) {
////            for (int j = 0; j < matrix.getV(); j++) {
////                setOfSums[i] += matrix.getElement(i, j);
////            }
////        }
////
////        return
//    }
//}
