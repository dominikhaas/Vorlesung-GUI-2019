/**
 * Created by dominik.haas on 21.06.18.
 */
export class HeaderModel {

  public series: string;
  public metric: string;
  public sampling: string
  public from: Date;
  public meassurement: string;
  public exclude: string;
  public aggregation: string;
  public until: Date;
  public host: string;
  public text: string;
  public graph: string;
  public process: string;
  public type: string;
  public expertMode: boolean;


  toString(): string {
    return JSON.stringify(this);
  }
}
