package model;

import java.util.Random;
import java.util.UUID;

/**
 * 図書IDをランダム生成するユーティリティクラス
 * 複数のID生成方式をサポートしています
 */
public class BookIDGenerator {
	
	// タイムスタンプベースのシーケンス
	private static long sequence = 0;
	private static final Object lock = new Object();
	
	/**
	 * UUIDを使用して図書IDを生成します
	 * 例：550e8400-e29b-41d4-a716-446655440000
	 * 
	 * @return ランダムな図書ID
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * タイムスタンプ + ランダムな数値で図書IDを生成します
	 * 例：BOOK20250622001500123456
	 * 
	 * @return ランダムな図書ID
	 */
	public static String generateTimestampBased() {
		long timestamp = System.currentTimeMillis();
		int random = new Random().nextInt(1000000);
		return String.format("BOOK%d%d", timestamp, random);
	}
	
	/**
	 * 接頭辞 + シーケンス + ランダムで図書IDを生成します
	 * 例：BK-2025062200-789456
	 * 
	 * @return ランダムな図書ID
	 */
	public static String generateSequenceBased() {
		long timestamp = System.currentTimeMillis();
		int randomSuffix = new Random().nextInt(1000000);
		
		synchronized(lock) {
			sequence++;
			if(sequence > 999999) {
				sequence = 1;
			}
		}
		
		return String.format("BK-%d-%06d", timestamp % 1000000000000L, randomSuffix);
	}
	
	/**
	 * 英数字のランダムな図書IDを生成します
	 * 例：KL7X9Q2M5P
	 * 
	 * @param length IDの長さ（デフォルト：10）
	 * @return ランダムな図書ID
	 */
	public static String generateAlphanumeric(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuilder id = new StringBuilder();
		
		for(int i = 0; i < length; i++) {
			id.append(characters.charAt(random.nextInt(characters.length())));
		}
		
		return id.toString();
	}
	
	/**
	 * 英数字のランダムな図書IDを生成します（デフォルト長10）
	 * 
	 * @return ランダムな図書ID
	 */
	public static String generateAlphanumeric() {
		return generateAlphanumeric(10);
	}
	
	/**
	 * プレフィックス付きのランダムな図書IDを生成します
	 * 例：BOOK-2025-KL7X9Q2M5P
	 * 
	 * @param prefix IDのプレフィックス
	 * @return ランダムな図書ID
	 */
	public static String generateWithPrefix(String prefix) {
		String randomPart = generateAlphanumeric(10);
		long timestamp = System.currentTimeMillis() / 1000000; // 年月日を簡易表現
		return String.format("%s-%d-%s", prefix, timestamp, randomPart);
	}
	
	/**
	 * プレフィックス付きのランダムな図書IDを生成します（デフォルトプレフィックス："BOOK"）
	 * 例：BOOK-2025-KL7X9Q2M5P
	 * 
	 * @return ランダムな図書ID
	 */
	public static String generateWithPrefix() {
		return generateWithPrefix("BOOK");
	}
}
