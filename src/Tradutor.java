
public class Tradutor {
	
	public static String classe(double v[]){
		
		String retorno ="";
		
		for(int i = v.length -3; i<v.length;i++){
			
			retorno +=Math.round(v[i]);
			
		}
		
		switch (retorno) {
		case "100":
			return "A";
			
		case "010":
		    return "B";
		case "001":
			return "C";
		

		default:
			return null;
		}
		
	}

}
