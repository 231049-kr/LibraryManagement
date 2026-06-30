Add MySQL 開発環境（docker-compose）と README の使用手順追加

- 目的
  - ローカル開発で MySQL 環境を簡単に立ち上げられるように、docker-compose 設定・初期スキーマ・README を追加します。
- 変更点
  - docker-compose.yml を追加（MySQL コンテナ）
  - db/init.sql を追加（初期データ含む）
  - .env.example を追加（環境変数サンプル）
  - README.md を更新（.env の使い方・起動手順・注意点）

注意: .env はシークレットを含むためコミットしないでください。
