package com.flygram.interfaces;

@FunctionalInterface
public interface QuintaFunction<U, W, X, Y, Z, R> {
	R apply(U u, W w, X x, Y y, Z z);
}
