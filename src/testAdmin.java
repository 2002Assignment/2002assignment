import java.text.ParseException;


public class testAdmin {

	public static void main(String[] args)throws ParseException {
		PriceSetting ps=new PriceSetting();
		Database db=new Database();
		db.serialize2(ps, "PriceSetting.dat");
		Admin admin=new Admin();
		admin.main2();
	}

}
