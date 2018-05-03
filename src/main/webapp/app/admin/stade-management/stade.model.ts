export class Stade {
    public id?: any;
    public nom?: string;
    public ville?: string;
    public nombrePlaces?: number;
    public createdBy?: string;
    public lastmodifiedBy?: string;
    public createdDate?: Date;
    public lastModifiedDate?: Date

    constructor(
        id?: any,
        nom?: string,
        ville?:string,
        nombrePlaces?: number,
        createdBy?: string,
        lastmodifiedBy?: string,
        createdDate?: Date,
        lastModifiedDate?: Date
    ) {
        this.id = id ? id : null;
        this.nom = nom ? nom : null;
        this.ville = ville ? ville : null;
        this.nombrePlaces = nombrePlaces ? nombrePlaces : null;
        this.createdBy = createdBy ? createdBy : null;
        this.lastmodifiedBy = lastmodifiedBy ? lastmodifiedBy : null;
        this.createdDate = createdBy ? createdDate : null;
        this.lastModifiedDate = lastModifiedDate  ? lastModifiedDate : null;
    }
}
