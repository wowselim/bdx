package com.nilunder.bdx.utils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.vecmath.Vector3f;

public class Random {

	public static <T> T choice(List<T> list){
		return list.get(ThreadLocalRandom.current().nextInt(list.size()));
	}

	@SafeVarargs
	public static <T> T choice(T... args) {
		return args[ThreadLocalRandom.current().nextInt(args.length)];
	}

	public static float random(){
		return ThreadLocalRandom.current().nextFloat();
	}
	
	public static void seed(long seed){
		ThreadLocalRandom.current().setSeed(seed);
	}

	public static float random(float min, float max){
		return (min + (random() * (max - min)));
	}

	public static Vector3f direction(){
		Vector3f vec = vector();
		vec.normalize();
		if (vec.length() == 0)
			vec = new Vector3f(1, 0, 0);
		return vec;
	}

	public static Vector3f vector(){
		List<Integer> ints = Arrays.asList(1, -1);
		return new Vector3f(
				Random.random() * Random.choice(ints),
				Random.random() * Random.choice(ints),
				Random.random() * Random.choice(ints));
	}

	public static Color color(){
		return new Color(Random.random(0, 1),
				Random.random(0, 1),
				Random.random(0, 1),
				Random.random(0, 1));
	}

}
