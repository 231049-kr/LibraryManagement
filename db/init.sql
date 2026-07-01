-- データベース作成
CREATE DATABASE IF NOT EXISTS tutorial_memo_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- データベースを選択
USE tutorial_memo_db;

-- books テーブル作成（図書管理用）
CREATE TABLE IF NOT EXISTS books (
    book_id INT NOT NULL AUTO_INCREMENT COMMENT '図書ID',
    title VARCHAR(255) NOT NULL COMMENT '図書タイトル',
    author VARCHAR(100) NOT NULL COMMENT '著者名',
    publisher VARCHAR(100) NOT NULL COMMENT '出版社',
    category VARCHAR(50) NOT NULL COMMENT 'カテゴリー',
    quantity INT NOT NULL DEFAULT 1 COMMENT '数量',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
    PRIMARY KEY (book_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 初期データの挿入
INSERT INTO books (title, author, publisher, category, quantity) VALUES 
('Java入門 第3版', '結城浩', 'SBクリエイティブ', 'プログラミング', 5),
('SQLポケットリファレンス', 'ミック', '技術評論社', 'データベース', 3),
('Webアプリケーション設計 徹底解説', '佐藤直生', 'マイナビ出版', 'Web開発', 2),
('MySQL完全ガイド', '月本龍之介', 'IT領域出版', 'データベース', 4),
('Servlet・JSP ポケットリファレンス', '山田祥寛', '技術評論社', 'Web開発', 3);

-- reading_memos テーブル作成（読書メモ用）
CREATE TABLE IF NOT EXISTS reading_memos (
    memo_id INT NOT NULL AUTO_INCREMENT COMMENT 'メモID',
    title VARCHAR(100) NOT NULL COMMENT 'タイトル',
    memo_text VARCHAR(500) NOT NULL COMMENT 'メモ本文',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
    PRIMARY KEY (memo_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- reading_memos テーブルの初期データ
INSERT INTO reading_memos (title, memo_text) VALUES 
('Java入門', 'クラスとインスタンスの違いを復習する'),
('SQL基礎', 'SELECT と WHERE を使った検索を練習する'),
('Web開発', 'Servlet から JSP へ値を渡す流れを確認する');
