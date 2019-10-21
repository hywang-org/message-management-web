package com.flash.message.utils;

import java.util.Random;

public class PassWordUtil {

	public static String getPassword() {
		String password = "12345678";
		int[] pwdindex = { 0, 1, 2, 3, 4, 5, 6, 7 };

		char[] specialCharacters = { '@', '#', '.', '!', '$' };

		char[] numbers = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		char[] upperLetters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		char[] lowerLetters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

		char[] allCharacters = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
				'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
				'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z' };

		// 1. 随机生成特殊字符，随机 放到密码2-7位置中(特殊字符不出现在开头或结尾)
		// System.out.println("随机生成特殊字符，随机 放到密码2-7位置中");
		int aindex = new Random().nextInt(5);
		// System.out.println(specialCharacters[aindex]);
		int aposition = new Random().nextInt(6) + 1;
		// System.out.println(password.charAt(aposition));
		password = password.replace(password.charAt(aposition), specialCharacters[aindex]);
		// System.out.println(password);

		// 2. 随机生成数据，随机放到1-8位置中（除去第1步占用的位置）
		int bindex = new Random().nextInt(10);
		// System.out.println(numbers[bindex]);
		int bposition = 0;
		do {
			bposition = new Random().nextInt(8);
		} while (bposition == aposition);
		// System.out.println(password.charAt(bposition));
		password = password.replace(password.charAt(bposition), numbers[bindex]);
		// System.out.println(password);

		// 3. 随机生成大写字母，随机放到1-8位置中（除去第1、2步占用的位置）
		int cindex = new Random().nextInt(26);
		// System.out.println(upperLetters[cindex]);
		int cposition = 0;
		do {
			cposition = new Random().nextInt(8);
		} while (cposition == aposition || cposition == bposition);
		// System.out.println(password.charAt(bposition));
		password = password.replace(password.charAt(cposition), upperLetters[cindex]);
		// System.out.println(password);

		// 4. 随机生成小写字母，随机放到1-8位置中（除去第1、2、3步占用的位置）
		int dindex = new Random().nextInt(26);
		// System.out.println(lowerLetters[dindex]);
		int dposition = 0;
		do {
			dposition = new Random().nextInt(8);
		} while (dposition == aposition || dposition == cposition || dposition == bposition);
		// System.out.println(password.charAt(bposition));
		password = password.replace(password.charAt(dposition), lowerLetters[dindex]);
		// System.out.println(password);

		// 前4步保证密码包含（特殊字符&大写字母&小写字母&数字 且位置是随机的）
		// 5. 随机生成数字大小写字母，随机放到1-8位置中（除去第1、2、3、4步占用的位置，余下四位）
		for (int i = 0; i < pwdindex.length; i++) {
			if (pwdindex[i] != aposition && pwdindex[i] != bposition && pwdindex[i] != cposition
					&& pwdindex[i] != dposition) {
				int eindex = new Random().nextInt(62);
				password = password.replace(password.charAt(pwdindex[i]), allCharacters[eindex]);
			}
		}
		return password;
	}

	public static void main(String[] args) throws Exception {
		String md5a = getPassword();
		System.out.println(md5a);
	}
	
    // 生成随机数字和字母,
    public static String getRomdomString(int length) {
        String val = "";
        Random random = new Random();
        // length为几位密码
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
