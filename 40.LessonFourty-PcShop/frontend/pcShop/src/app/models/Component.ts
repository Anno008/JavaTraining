import { Brand } from "./Brand";
import { ComponentType } from "./ComponentType";

export interface Component {
    id?: number;
    brand: Brand;
    componentType: ComponentType;
    name: string;
    price: number;
}
