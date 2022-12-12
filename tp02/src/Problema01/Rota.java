import java.util.Comparator;

public class Rota {

	private int id;
	private int km;

	public int getId() {
		return id;
	}

	public int getKm() {
		return km;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public Rota(int id, int km) {
		super();
		this.id = id;
		this.km = km;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + " KM: " + this.km;
	}

	static class KmComparator implements Comparator<Rota> {
		@Override

		public int compare(Rota r1, Rota r2) {
			Integer km1 = r1.getKm();
			Integer km2 = r2.getKm();
			int compare = (int) Math.signum(km1.compareTo(km2));

			return compare * (-1);
		}

	}

}

	
	

