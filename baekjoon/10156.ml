let result = Scanf.scanf " %d %d %d" (fun a b c -> ((a*b)-c));;
Printf.printf "%d" (if(result > 0) then result else 0);;