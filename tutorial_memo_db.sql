
CREATE DATABASE IF NOT EXISTS tutorial_memo_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE tutorial_memo_db;

CREATE TABLE reading_memos (
    memo_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    memo_text VARCHAR(500) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (memo_id)
);

INSERT INTO reading_memos (title, memo_text) VALUES 
('Java入門', 'クラスとインスタンスの違いを復習する'),
('SQL基礎', 'SELECT と WHERE を使った検索を練習する'),
('Web開発', 'Servlet から JSP へ値を渡す流れを確認する');
