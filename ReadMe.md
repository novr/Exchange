# コーディングテスト

## 概要

為替レートの一覧を表示したり、入力した金額を他の通貨に換算するアプリを作って頂きます。

## サーバーAPI

為替レートの一覧を返すAPIを用意しました。下記のエンドポイントにGETリクエストを送って、為替データを取得してください。

`{api.base}/exchange_rates`

レスポンス例:

```
{
  “aud”: {
    “gbp”: 1.0015,
    “jpy”: 1.1000
  },
  “gbp”: {
    “aud”: 1.2156,
    “jpy”: 0.8001
  },
  “jpy”: {
    “aud”: 0.5151,
    “gbp”: 1.8991
  }
}
```

* レートの値は、取得する度にランダムで変わります。
* 通貨の種類は増減することがあります。
* たまに404または500が返ってくるので、アラートで適宜エラーメッセージを表示してください。

## Androidアプリ

アプリの要件は、下記の通りです。

### レート表示画面

* 通貨を選択できるメニューがあり、選択すると、その通貨に対するレート一覧を表示（例えば、"JPY"を選ぶと、対日本円の各レートを表示）。
* 選択した通貨は、アプリ終了→起動を跨いで保持すること。
* データを更新するための更新ボタンがあること。
* 画面表示時に最新データに自動更新すること。
* 最終更新日時を画面上に表示すること。
* レート換算画面（下記参照）を開くためのボタンがあること。

### レート換算画面

* 全画面ではなくモーダルダイアログで実装してください。
* 金額入力用のフィールドと、換算元通貨、換算先通貨を選択するメニューがあること。
* 換算元通貨は、レート表示画面で選択していたものをデフォルト値としてください。
* "換算ボタン"は設けず、フィールドやメニューの値を変えると、自動的にレートと換算後の金額が表示されるようにしてください。

### その他

* ネットワーク接続がなくても利用ができるように実装してください。
* 言語はJavaを用いてください。
* 拡張性の高い設計を心掛けてください。
* 必要に応じてOSSライブラリもお使いください。
* Minimum SDK Versionは14とします。
* JUnitのテストがあると尚良いです。