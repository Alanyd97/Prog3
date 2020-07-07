
import java.util.Arrays;

/* Una familia, con su cantidad de dias, y una arreglo con el top de 4 dias preferidos */
public class Familia implements  Comparable<Familia>{

	private int id;
	private int miembros;
	private int[] diasPreferidos;
	private int preferido=0;
	private int designado;
	private int indiceDesignado;
	public Familia(int id, int miembros, int... diasPreferidos) {
		this.id = id;
		this.miembros = miembros;
		this.diasPreferidos = diasPreferidos;
		this.indiceDesignado = 0;
	}

	public int getDesignado(){
		return designado;
	}

	public void setDesignado(int a){
		designado = a;
	}

	public int getIndiceDesignado() {
		return this.indiceDesignado;
	}

	public void setIndiceDesignado(int index){
		this.indiceDesignado = index;
	}

	public int getPreferido() { return preferido; }

	public void setPreferido() {
		if (preferido + 1 <= diasPreferidos.length -1)
			this.preferido++;
		else {
			preferido=-1;
		}
	}

	public void setId(int id) {
		this.id = id;
	}

	/* Id de la familia */
	public int getId() {
		return id;
	}


	/* Retorna la cantidad de miembros de la familia. */
	public int miembros() {
		return miembros;
	}


	/* Dado un indice entre 0 y 4, retorna el d�a preferido por la familia para ese indice. */
	public int preferenciaEn(int indice) {
		return this.diasPreferidos[indice];
	}

	public boolean contiene(int i){
		for (int j = 0; j < 5; j++) {
			if (diasPreferidos[j] == i){
				return true;
			}
		}
		return false;
	}

	/* Retorna el dia preferido de la familia */
	public int diaPreferido(){
		return preferenciaEn(0);
	}


	@Override
	public String toString() {
		return "Familia: id=" + id + ", miembros=" + miembros + ", preferencias=" + Arrays.toString(diasPreferidos);
	}

	@Override
	public int compareTo(Familia o) {
		return Integer.compare( this.miembros(), o.miembros());
	}
}