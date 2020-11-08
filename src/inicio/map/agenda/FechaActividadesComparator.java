package inicio.map.agenda;

import java.util.Comparator;
import java.util.Date;

public class FechaActividadesComparator implements Comparator<Date> {

	@Override
	public int compare(Date fecha1, Date fecha2) {
		if (fecha1.after(fecha2)) {
			return 1;
		} else if (fecha1.before(fecha2)) {
			return -1;
		}
		return 0;
	}

}
