"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var CadastroMessage = (function () {
    function CadastroMessage(message, include) {
        this._message = message;
        this._include = include;
    }
    Object.defineProperty(CadastroMessage.prototype, "message", {
        get: function () {
            return this._message;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(CadastroMessage.prototype, "include", {
        get: function () {
            return this._include;
        },
        enumerable: true,
        configurable: true
    });
    return CadastroMessage;
}());
exports.CadastroMessage = CadastroMessage;
//# sourceMappingURL=cadastro.message.js.map