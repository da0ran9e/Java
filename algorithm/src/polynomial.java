import java.util.*;

public class polynomial {
    public static class Terms{
        int c;
        int e;

        public Terms(int c, int e) {
        }
    }
    public static int pow(int n, int x){
        int res=1;
        for (int i=0; i<x; i++){
            res*=n;
        }
        return res;
    }

    public static void sort(int index){
        for(int i=1; i<=terms[index]; i++){
		for (int j=1; j<=terms[index]-i; j++){
			if(poly[index][j].e < poly[index][j+1].e){
				Terms temp = poly[index][j];
				poly[index][j] = poly[index][j+1];
				poly[index][j+1] = temp;
			}
		}
	}
    }
    final static int N_MAX = 10001;
    static Terms[][] poly = new Terms[N_MAX][N_MAX];
    static boolean[] exist = new boolean[N_MAX];
    static int[] terms = new int[N_MAX];
    static int[][] pows = new int[N_MAX][N_MAX];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String command;
        int poly_id, poly_id1, poly_id2, coef, exp, variable_value, result_poly_id;

        do {
            command = in.next();
            if (command.equals("*")) continue;

            if (command.equals("Create")) {
                poly_id = in.nextInt();
                if (!exist[poly_id]) exist[poly_id] = true;
            } else if (command.equals("AddTerm")) {
                poly_id = in.nextInt();
                coef = in.nextInt();
                exp = in.nextInt();
                if (pows[poly_id][exp] == 0) {
                    terms[poly_id]++;
                    poly[poly_id][terms[poly_id]] = new Terms(coef, exp);
                    pows[poly_id][exp] = terms[poly_id];
                } else {
                    poly[poly_id][pows[poly_id][exp]].c += coef;
                }
                if (!exist[poly_id]) exist[poly_id] = true;
            } else if (command.equals("EvaluatePoly")) {
                poly_id = in.nextInt();
                variable_value = in.nextInt();
                int result = 0;
                if (exist[poly_id]) {
                    for (int i = 1; i <= terms[poly_id]; i++) {
                        result += poly[poly_id][i].c * pow(variable_value, poly[poly_id][i].e);
                    }
                    System.out.println(result);
                } else {
                    System.out.println(0);
                }
            } else if (command.equals("AddPoly")) {
                poly_id1 = in.nextInt();
                poly_id2 = in.nextInt();
                result_poly_id = in.nextInt();
                for (int i = 1; i <= terms[poly_id1]; i++) {
                    poly[result_poly_id][i] = new Terms(poly[poly_id1][i].c, poly[poly_id1][i].e);
                    pows[result_poly_id][poly[poly_id1][i].e] = 1;
                    terms[result_poly_id]++;
                }
                for (int i = 1; i <= terms[poly_id2]; i++) {
                    if (pows[result_poly_id][poly[poly_id2][i].e] == 0) {
                        terms[result_poly_id]++;
                        pows[result_poly_id][poly[poly_id2][i].e] = terms[result_poly_id];
                        poly[result_poly_id][terms[result_poly_id]] = new Terms(poly[poly_id2][i].c, poly[poly_id2][i].e);
                    } else {
                        poly[result_poly_id][i].c += poly[poly_id2][i].c;
                    }
                }
            } else if (command.equals("PrintPoly")) {
                poly_id = in.nextInt();
                sort(poly_id);
                for (int i = 1; i <= terms[poly_id]; i++) {
                    System.out.printf("%d %d ", poly[poly_id][i].c, poly[poly_id][i].e);
                }
                System.out.println();
            } else if (command.equals("Destroy")) {
                poly_id = in.nextInt();
            }

        }while(!command.equals("*"));
    }
}