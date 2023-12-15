public class Task1 {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Введите 2 числа");
			return;
		}

		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);

		System.out.println(line(n, m));
	}

	public static String line(int n, int m) {
		String result = "1";
		if (m < 1 || n < 1)
			return "m и n должны быть >0";
		if (n == 1)
			return result;



		int current = 1;
		int cnt = 1;
		while (true) {
			int next;
			if (n >= current + m - 1) {
				next = current + m - 1;
			} else {
				next = (current + m - 1) % n;
				if (next == 0) {
					next = current + 1;
				}
			}
			if (next == 1)
				cnt++;
			if (cnt > 1)
				break;
			current = next;
			result += String.valueOf(current);
		}
		return result;
	}
}