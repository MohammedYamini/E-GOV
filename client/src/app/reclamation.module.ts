export interface ApiResponse {
    message: string;
    reclamation: Reclamation;
}

export interface Reclamation {
    id : Number
    matriculation_interior : String
    matriculation_number : String
    first_time_in_circulation : Date | string;
    first_use_in_morocco : Date | string
    mutation : Date | string
    particular_vehicle : string
    address : String
    end_of_validity : Date | string
    type_of_usage : String
    owner : String
    payment_id : String
}
