//メインクラス
class MainClass {	// MainClassクラスの定義

	// Javaのエントリポイント
	public static void main(String[] args) {	// mainメソッドの定義

		// CustomObjectを1つ生成.
		CustomObject obj1 = new CustomObject();	// CustomObjectオブジェクトobj1を生成.

		// 文字列をセット.
		obj1.setStr("ABC");	// obj1.setStrで"ABC"をセット.

		// 整数値をセット.
		obj1.setValue(123);	// obj1.setValueで123をセット.

		// obj1の中身を出力.
		System.out.println("obj1.toString() = " + obj1.toString());	// obj1.toString()を出力.

		// CustomObjectオブジェクトをもうひとつ用意.
		CustomObject obj2;	// obj2を用意.

		// tryで囲む.
		try{

			// クローン.
			obj2 = obj1.clone();	// obj1.cloneでobj2にクローン.

			// obj2の内容を変更.
			obj2.setStr("XYZ");	// obj2.setStrで"XYZ"をセット.
			obj2.setValue(789);	// obj2.setValueで789をセット.

			// obj2の中身を出力.
			System.out.println("obj2.toString() = " + obj2.toString());	// obj2.toString()を出力.

			// obj1の中身を出力.
			System.out.println("obj1.toString() = " + obj1.toString());	// obj1.toString()を出力.

		}
		catch (Exception ex){
			System.exit(-1); // 以上終了.
		}

	}

}