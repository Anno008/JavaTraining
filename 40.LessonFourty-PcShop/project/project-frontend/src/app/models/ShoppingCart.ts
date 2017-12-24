import { ShoppingCartItem } from "./ShoppingCartItem";

export interface ShoppingCart {
    components: ShoppingCartItem[];
    amount: number;
}
