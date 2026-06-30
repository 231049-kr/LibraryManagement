# MySQL 開発環境 (docker-compose)

このブランチ (add-mysql-docker) には、ローカル開発用の MySQL を簡単に立ち上げるための設定と手順を追加しています。

> 重要: このドキュメントはローカル／開発環境向けです。本番環境ではシークレット管理（GitHub Secrets, Vault, Docker Secrets など）を使用してください。

## 追加されるファイル（予定）
- `docker-compose.yml` — MySQL コンテナ定義
- `db/init.sql` — 初期スキーマと初期データ
- `.env.example` — 環境変数の例（パスワード等は各自で設定してください）

（これらはこのブランチに配置されます。まだ存在しない場合は同じブランチで追加されているはずです。）

---

## 使い方（他のメンバー向け：簡単・安全な手順）

1. .env を自分用に作る（必須）

   - Unix/macOS:
     ```bash
     cp .env.example .env
     ```
   - Windows PowerShell:
     ```powershell
     Copy-Item .env.example .env
     ```
   - Windows cmd:
     ```cmd
     copy .env.example .env
     ```

2. .env を編集して自分の値を設定する（必須）

   - 例（エディタで開いて編集してください）:
     ```text
     MYSQL_ROOT_PASSWORD=your_root_password
     MYSQL_DATABASE=tutorial_memo_db
     MYSQL_USER=appuser
     MYSQL_PASSWORD=your_app_password
     ```
   - 各変数の意味:
     - MYSQL_ROOT_PASSWORD: MySQL の root ユーザーのパスワード（管理用）
     - MYSQL_DATABASE: 初期作成されるデータベース名
     - MYSQL_USER / MYSQL_PASSWORD: アプリが使う一般ユーザー

3. .env をコミットしない（重要）

   - .env はシークレットを含むため、リポジトリにプッシュしないでください。
   - 推奨: リポジトリルートに `.env` を追加するために `.gitignore` を更新します:
     ```bash
     echo ".env" >> .gitignore
     ```

4. Docker Compose で起動

   ```bash
   docker compose up -d
   ```

   - 起動確認:
     ```bash
     docker compose ps
     docker compose logs -f db
     ```

5. MySQL への接続例

   - ホスト側から接続（ポート 3306 を公開している場合）:
     ```bash
     mysql -h 127.0.0.1 -P 3306 -u appuser -p
     ```
   - コンテナ内から接続:
     ```bash
     docker exec -it library_management_db mysql -uappuser -p tutorial_memo_db
     ```

6. 初期化スクリプト (db/init.sql) の扱い

   - `db/init.sql` は MySQL Docker イメージの仕様で「コンテナ初回起動時にのみ」実行されます。
   - 既にデータボリュームが存在する場合、init スクリプトは再実行されません。再実行したい場合はボリュームを削除して再作成してください（データが消えます）：
     ```bash
     docker compose down -v
     docker compose up -d
     ```

   - ボリュームだけを削除する場合（注意: データ消去）:
     ```bash
     docker compose down
     docker volume rm library_management_db_data
     docker compose up -d
     ```

7. セキュリティ・運用上の注意

   - 本番用には平文の .env を使わないでください。各種 Secrets 機能や Vault、Docker Secrets を利用してください。
   - パスワードは強力なものを使い、安全なチャネルで共有してください（パスワード管理ツール等）。

---

## 便利なコマンドまとめ

- .env の作成:
  - `cp .env.example .env`
- 起動:
  - `docker compose up -d`
- 停止:
  - `docker compose down`
- 完全リセット（データ消える）:
  - `docker compose down -v`
- ログ確認:
  - `docker compose logs -f db`
- コンテナ内 mysql:
  - `docker exec -it library_management_db mysql -uappuser -p tutorial_memo_db`

---

必要なら、この README の内容を PR の説明文としても使います。PR 作成を希望する場合はその旨を教えてください。