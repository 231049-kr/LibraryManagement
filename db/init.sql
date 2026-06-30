-- データベース作成
CREATE DATABASE IF NOT EXISTS tutorial_memo_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- データベースを選択
USE tutorial_memo_db;

-- reading_memos テーブル作成
CREATE TABLE IF NOT EXISTS reading_memos (
    memo_id INT NOT NULL AUTO_INCREMENT COMMENT 'メモID',
    title VARCHAR(100) NOT NULL COMMENT 'タイトル',
    memo_text VARCHAR(500) NOT NULL COMMENT 'メモ本文',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時',
    PRIMARY KEY (memo_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 初期データの挿入
INSERT INTO reading_memos (title, memo_text) VALUES 
('Java入門', 'クラスとインスタンスの違いを復習する'),
('SQL基礎', 'SELECT と WHERE を使った検索を練習する'),
('Web開発', 'Servlet から JSP へ値を渡す流れを確認する');
