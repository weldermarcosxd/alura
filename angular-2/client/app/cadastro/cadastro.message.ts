export class CadastroMessage {

    private _message: string;
    private _include: boolean;

    constructor(message: string, include: boolean) {
        this._message = message;
        this._include = include;
    }

    public get message() : string {
        return this._message;
    }

    public get include() : boolean {
        return this._include;
    }
}
