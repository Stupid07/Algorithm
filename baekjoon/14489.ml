let s = Scanf.scanf " %d %d" (fun a b -> a+b);;
let c = Scanf.scanf " %d" (fun c -> 2*c);;
Printf.printf "%d" (if((s-c)>=0) then (s-c) else s);;