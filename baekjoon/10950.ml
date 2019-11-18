let rec loop i =
	let add = fun a b -> a+b in
	let readAndAdd = Scanf.scanf " %d %d" add in
	let print = Printf.printf "%d\n" readAndAdd in
	if i > 1 then loop (i-1);;

 Scanf.scanf " %d" loop;;