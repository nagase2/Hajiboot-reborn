module johndoe {

    export interface ButtonOptions extends InputOptions, JQueryUI.ButtonOptions {
        html?: any;
        functionkey?: string;
        location?: string;
        content?: string;
    }

    // =============================================================
    /**
     * Buttonの各種設定を保持します。
     * JQueryUIのクラスを継承しています({@link https://api.jqueryui.com/button/})
     * @class johndoe.ButtonOptions
     * @extends johndoe.InputOptions
     * @extends JQueryUI.ButtonOptions
    */
    /**
     * targetに設定したいhtmlを指定します。
     * @member {any} johndoe.ButtonOptions#html
    */
    /**
     * ファンクションキー名を指定します。
     * @member {string} johndoe.ButtonOptions#functionkey
     * @example "f5"
    */
    /**
     * "footer"を指定することによってフッタ配置のファンクションキーボタンを表します。
     * @member {string} johndoe.ButtonOptions#location
    */
    /**
     * HTMLを指定することによってbody部を差し替えます。
     * @member {string} johndoe.ButtonOptions#content
     */
    // =============================================================

    /**
     * インスタンス生成時の各種設定を保持します。
     * @member johndoe.Button#options
     * @type {johndoe.ButtonOptions}
     */
    /**
     * ファンクションキー毎のイベントハンドラを保持します。
     * @member johndoe.Button#handlers
     * @type {Array.<johndoe.Button_handlers>}
     */
    /**
     * ファンクションキー押下時のイベントハンドラです。
     * @callback johndoe.Button_handlers
     * @param {FuncKeyEventObject} eee イベントオブジェクト
     */
    // ↑ 型名の先頭がfunctionだとjsdoc生成に失敗する…
    export class Button extends Input<Button> {
        /** @inheritDoc */
        //TODO:Tsのコメントテスト
        options: ButtonOptions;
        handlers: { [functionType: string]: (e: FunctionKeyEventObject) => any; };

        /**
         * オブジェクトを構築します。
         * @class johndoe.Button
         * @extends johndoe.Input
         * @classdesc ボタンコンポーネント用のクラスです。
         * @param {johndoe.ButtonOptions} options 各種設定
         */
        constructor(options: ButtonOptions) {
            super(options);
            this.$el.addClass('ui-button');
            this.$el.button(options);
            options.html && this.html(options.html);
            options.text && this.text(options.text);

            if (options.functionkey) {
                this.$el.addClass('functionkey-button');
                var $container = this.$el.find('.ui-button-text');
                var $title = $('<div class="functionkey-title">');

                $container.wrapInner('<div class="functionkey-body">');
                $container.prepend($title.text(options.functionkey.toUpperCase()));

                if (options.content) {
                    // 指定された内容のHTMLでボディ部を差し替える
                    $container.find('.functionkey-body').html(options.content);
                }

                if (!options.location) {
                    // フッタ部のファンクションキーではないので個別にキーバインドする
                    this.bindFunctionkey(options.functionkey);
                }
            }
        }

        html(): string;
        html(htmlString: string): Button;
        html(func: (index: number, oldhtml: string) => string): Button;
        /**
         * htmlを取得/設定します。
         * @method johndoe.Button#html
         */
        html(): any {
            return this._attribute('html', arguments);
        }

        text(): string;
        text(text: string): Button;
        text(text: number): Button;
        text(text: boolean): Button;
        text(func: (index: number, text: string) => string): Button;
        /**
         * textを取得/設定します。
         * @method johndoe.Button#text
         */
        text() {
            if (this.options.functionkey) {
                if (arguments.length == 0) {
                    return this.$el.find('.functionkey-body').text();
                }
                this.$el.find('.functionkey-body').text(arguments[0]);
                return this;
            } else {
                return this._attribute('text', arguments);
            }
        }

        disabled(): boolean;
        disabled(disabled: boolean): Button;
        /**
         * 有効/無効を取得/設定します。
         * @method johndoe.Button#disabled
         */
        disabled() {
            return this._option('button', 'disabled', arguments);
        }

        /**
         * ファンクションキーに処理を紐付けます。
         * @method johndoe.Button#bindFunctionkey
         * @param {string}　functionkeyType ファンクションキー名を指定します。
         * @example button.bindFunctionkey("f5");
         */
        bindFunctionkey(functionType: string) {
            this.handlers || (this.handlers = {});
            if (!this.handlers[functionType]) {
                var handler = (e: FunctionKeyEventObject) => {
                    if (e.functionType === functionType) {
                        trigger(this.$el, 'click');
                        e.stopPropagation();
                    }
                }

                $(window).on('functionkey', handler);
                this.handlers[functionType] = handler;
            }
            return self;
        }

        /**
         * ファンクションキーに紐付けた処理を解除します。
         * @method johndoe.Button#unbindFunctionkey
         * @param {string}　functionkeyType ファンクションキー名を指定します。
         * @example button.unbindFunctionkey("f5");
         */
         unbindFunctionkey(functionType: string) {
            if (this.handlers) {
                var handler = this.handlers[functionType];
                if (handler) {
                    $(window).off('functionkey', handler);
                    delete this.handlers[functionType];
                }
            }
            return this;
        }

    }

}
