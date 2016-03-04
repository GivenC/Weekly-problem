public class Week2 {
	
	private char[][] saw_arry = null;
	private int col;
	private int row;
	private char default_fill = '-';
	
	public void printArray(String s, int col) {
		System.out.println("string is: [[" + s + "]] ");
		System.out.println("切分图片形式为:");
		System.out.println("**********************************************");
		createArray(s, col);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(this.saw_arry[i][j]);
			}
			System.out.println();
		}
		System.out.println("**********************************************");
		System.out.println("最大O是:" + search());
		System.out.println();
	}
	
	private int search() {
		int max = 0;
		//因为增加了 填充数据,所以在数组选到标志数据时候
		boolean isFinish = false;
		for (int i = 0; i < row; i++) {
			
			for (int j = 0; j < col; j++) {
				int o_size = 0;
				//对矩阵进行处理
				if (saw_arry[i][j] == 'X') {
					//开始计算 x 对应位的 O数量
					if (i > 0 && i < row && saw_arry[i-1][j] == 'O') {
						o_size++;
					} 
					if (i+1 < row && saw_arry[i+1][j] == 'O') {
						o_size++;
					}
					if (j > 0 && j < col && saw_arry[i][j-1] == 'O') {
						o_size++;
					}
					
					if (j+1 < col && saw_arry[i][j+1] == 'O') {
						o_size++;
					}
					
				}
				if (max < o_size) {
					max = o_size;
				}
				if (saw_arry[i][j] == default_fill)
				{
					isFinish = true;
					break;
				}
			}
			//根据  Roadsong 添加等于4 跳出循环处理
			if (max == 4) 
				break;
			if (isFinish)
			{
				break;
			}
			
		}
		return max;
	}
	
	private void createArray(String str, int col) {
		int len = str.length();
		int row = len / col;
		//判断指定col是否大于可填充行数
		if (len % col != 0) {
			row = row + 1;
		}
		if (row == 0) {
			row = 1;
		}
		this.row = row;
		this.col = col;
		System.out.println("row is:" + row + " col is:" + col);
		this.saw_arry = new char[row][col];
		fillArray(this.saw_arry, str);
	}
	
	private void fillArray(char[][] fill_array, String str) {
		fillArray(fill_array, str, this.row, this.col);
	}
	
	private void fillArray(char[][] fill_array, String str, int row, int col) {
		//saw_arry = new char[row][col];
		char[] fillChar = str.toCharArray();
		int x = 0, len = fillChar.length;
		
		for (x = 0; x < len; ) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (x >= len) {
						fill_array[i][j] = default_fill;
					} else {
						fill_array[i][j] = fillChar[x++];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Week2 week2 = new Week2();
		week2.printArray("OXOOOXOXOXOXXOX", 5);
		week2.printArray("OXOOOXOXOXOXXOX", 10);
		week2.printArray("XOOXOOOOOOXOOXOXXXOX", 5);
		week2.printArray("OXOOOXOXOXOXXOX", 50);
		week2.printArray("OXOOOXOXOXOXXOXXXXXOOOOOOOOOO", 3);
	}
}
