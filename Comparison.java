
public class Comparison {

	/**
	 * Ранг (размер) матрицы.
	 */
	private int rank;

	/**
	 * Матрица парных сравнений.
	 * a[i][j] = w[i] / w[j], где w[] - массив весов объектов.
	 */
	private float[][] a;

	public Comparison() {}

	public Comparison(int rank) {
		this.rank = rank;
		a = new float[rank][rank];
	}

	public boolean setMatrix (int rank, float[][] matrix) {
		//TODO: check rank and matrix size
		this.rank = rank;
		this.a = matrix;
		return true;
	}

	/**
	 * Возвращает собственный вектор матрицы.
	 * @return собственный вектор
	 */
	public float[] getEigenvector() {
		// ae = A * e
		float[] ae = new float[rank];
		// eae = e^T * A * e
		float eae = 0;
		for (int i = 0; i < rank; i++) {
			ae[i] = 0;
			for (int j = 0; j < rank; j++)
				ae[i] += a[i][j];
			eae += ae[i];
		}
		// w = ae / eae
		float[] w = new float[rank];
		for (int i = 0; i < rank; i++)
			w[i] = ae[i] / eae;
		return w;
	}

	/**
	 * Возвращает собственное число матрицы.
	 * @return собственное число
	 */
	public float getEigenvalue() {
		// ea = e^T * A
		float[] ea = new float[rank];
		float[] w = getEigenvector();
		float lambda = 0;
		for (int i = 0; i < rank; i++) {
			ea[i] = 0;
			for (int j = 0; j < rank; j++)
				ea[i] += a[j][i];
			lambda += ea[i] * w[i];
		}
		return lambda;
	}

	/**
	 * Возвращает индекс согласованности матрицы.
	 * @return индекс согласованности
	 */
	public float getConsistencyIndex() {
		return (rank - getEigenvalue()) / (rank - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Comparison c = new Comparison();
		c.setMatrix(3, new float[][] { {1f, 2f, 1f/3f}, {0.5f, 1f, 0.2f}, {3f, 5f, 1f} });
		float[] w = c.getEigenvector();
		for (int i = 0; i < 3; i++)
			System.out.print(w[i]+", ");
		System.out.println();
		System.out.println(c.getEigenvalue());
		System.out.println(c.getConsistencyIndex());
	}

}
