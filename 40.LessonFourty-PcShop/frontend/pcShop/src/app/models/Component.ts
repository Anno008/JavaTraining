import { Brand } from "./Brand";
import { ComponentType } from "./ComponentType";

export interface Component {
    id?: number;
    brand: Brand;
    name: string;
    price: number;
}
