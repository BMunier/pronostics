export class Pays{
    id: number;
    nom: string;
    code: string;

    constructor(
        id?: any,
        nom?: string,
        code?: string){
            this.id = id ? id : null;
            this.nom = nom ? nom : null;
            this.code = code ? code : null;}
}