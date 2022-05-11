module hexdisp(x0, x1, x2, x3, f0, f1, f2, f3, f4, f5, f6);
	input x0, x1, x2, x3;
	output f0, f1, f2, f3, f4, f5, f6;

	assign f0 = (~x0 & x1 & ~x2 & ~x3) | (~x0 & ~x1 & ~x2 & x3) | (x0 & x1 & ~x2 & x3) | (x0 & ~x1 & x2 & x3); 
	assign f1 = (~x0 & x1 & ~x2 & x3) | (x0 & x2 & x3) | (x1 & x2 & ~x3) | (x0 & x1 & x2) | (x0 & x1 & ~x3);
	assign f2 = (~x0 & ~x1 & x2 & ~x3) | (x0 & x1 & x2) | (x0 & x1 & ~x3);
	assign f3 = (~x0 & x1 & ~x2 & ~x3) | (~x0 & ~x1 & ~x2 & x3) | (x1 & x2 & x3) | (x0 & ~x1 & x2 & ~x3);
	assign f4 = (~x0 & x3) | (~x0 & x1 & ~x2) | (~x1 & ~x2 & x3);
	assign f5 = (~x0 | ~x2) & (~x1| x3) & (~x0 | x1) & (x2 | x3) & (x0 | ~x1 | x2);
	assign f6 = (x0 | ~x1 | x2) & (x0 | x1 | ~x2) & (~x2 | x3) & (~x0 | x1) & (~x0 | ~x3);
endmodule




module name(x0, x1, x2, x3, f0, f1, f2, f3, f4, f5, f6);
	input x0, x1, x2, x3;
	output f0, f1, f2, f3, f4, f5, f6;


	assign f0 = x0 | (x1 & x2) | (~x1 & ~x2 & x3);
	assign f1 = (~x0 & ~x1 & ~x3) | (x2 & ~x3);
	assign f2 = (~x0 & ~x1 & ~x3) | (x2 & ~x3);
	assign f3 = x3 & (~x2 | ~x1);
	assign f4 = (x1 & ~x2 & ~x3) | (x1 & x2 & x3);
	assign f5 = x1 & x2 & x3;
	assign f6 = (x2 | ~x3) & (x1 | ~x2 | x3) & (x2 | ~x1);
endmodule




module lab2demo(x0, x1, x2, x3, y0, y1, y2, y3, f0, f1, f2, f3, f4, f5, f6, s0, s1, s2, s3, s4, s5, s6);
	input x0, x1, x2, x3, y0, y1, y2, y3;
	output f0, f1, f2, f3, f4, f5, f6, s0, s1, s2, s3, s4, s5, s6;

	hexdisp hexdisp1(x0, x1, x2, x3, f0, f1, f2, f3, f4, f5, f6);
	name name1(y0, y1, y2, y3, s0, s1, s2, s3, s4, s5, s6);
endmodule


	