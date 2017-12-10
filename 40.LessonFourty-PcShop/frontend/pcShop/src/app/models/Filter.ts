import { Brand } from "./Brand";
import { ComponentType } from "./ComponentType";

export interface Filter {
    brand?: Brand;
    componentType?: ComponentType;
    name?: string;
}
