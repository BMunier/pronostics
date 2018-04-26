import { TeamData } from './team-data.model';

export class Team {
    constructor(
        public id: number,
        public team: string,
        public point: number
    ){}
}