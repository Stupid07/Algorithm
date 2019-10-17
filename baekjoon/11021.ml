let rec loop i n =
	let add = fun a b -> a+b in
	let readAndAdd = Scanf.scanf " %d %d" add in
	let print = Printf.printf "Case #%d: %d\n" i readAndAdd in
	if i < n then loop (i+1) n;;

 Scanf.scanf " %d" (fun num -> loop 1 num);;