let rec loop i n =
	let add = fun a b -> a+b in
	let print a b = Printf.printf "Case #%d: %d + %d = %d\n" i a b (add a b) in
	let read = Scanf.scanf " %d %d" print in
	if i < n then loop (i+1) n;;

 Scanf.scanf " %d" (fun num -> loop 1 num);;