public class NeuralArray1 {
	double[][] gewicht;
	double fire;

	public NeuralArray1(double[][] gewicht, double fire) {
			this.gewicht = gewicht;
			this.fire = fire;
		}

	public double doit(double[] in, int z) {
		double me = 0;
		for (int i = 0; i < gewicht[z].length; i++) {
			me = me + (in[i] * this.gewicht[z][i]);
		}

		if (me > fire) {
			return 1;
		} else {
			return 0;
		}
	}

	public void lernyes(double[] in, int z) {
		for (int j = 0; j < gewicht.length; j++) {
			for (int i = 0; i < gewicht[z].length; i++) {
				if (in[i] >= 1) {
					this.gewicht[z][i] = this.gewicht[z][i] + 0.1;
				} else {
					this.gewicht[z][i] = this.gewicht[z][i] - 0.1;

				}
			}
		}

	}

	public void lernno(double[] in, int z) {
		for (int j = 0; j < gewicht.length; j++) {
			for (int i = 0; i < gewicht[z].length; i++) {
				if (in[i] >= 1) {
					this.gewicht[z][i] = this.gewicht[z][i] - 0.1;
				} else {
					this.gewicht[z][i] = this.gewicht[z][i] + 0.1;

				}
			}
		}

	}

	public double[][] get() {
		return gewicht;
	}

}
