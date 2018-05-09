import { TeamData } from './team-data.model';

export class Team {
    public id?: number;
    public name?: string;
    public pays?: string;
    public rang?: number;
    public code?: string

    constructor(
        id?: number,
        name?: string,
        pays?: string,
        rang?: number,
        code?: string
    ){
        this.id = id ? id : null,
        this.name = name ? name : null,
        this.pays = pays ? pays : null,
        this.rang = rang ? rang : null,
        this.code = code ? code : null
    }
}