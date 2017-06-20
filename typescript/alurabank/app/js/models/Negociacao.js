class Negociacao {
    constructor(data, quantidade, valor) {
        this._data = data;
        this._quantidade = quantidade;
        this._valor = valor;
    }
    get valor() {
        return this._valor;
    }
    get quantidade() {
        return this._quantidade;
    }
    get data() {
        return this._data;
    }
    get volume() {
        return this._valor * this._quantidade;
    }
}
