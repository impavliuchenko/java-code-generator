export class User {
  constructor(
    public username: string,
    public password: string,
    public id?: number,
    public name?: string,
    public nickName?: string,
    public dateBirthday?: any,
    public authorities?: any[],
    ) {}
}
