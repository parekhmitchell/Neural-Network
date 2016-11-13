public class Perceptron {
	private float[] weights;
	private float c = 0.01;

	public Perceptron(int n) {
		weights = new float[n];
		for(int i = 0; i < n; i++)
			weights[i] = random(-1,1);
	}

	public int feedforward(float[] inputs) {
    	float sum = 0;
    	
    	for(int i = 0; i < weights.length; i++)
      		sum += inputs[i]*weights[i];
    
    	return activate(sum);
    }

	public int activate(float sum) {
		if(sum > 0) 
			return 1;
    	else 
    		return -1;
    }

    public void train(float[] inputs, int desired) {
    	int guess = feedforward(inputs);
    	float error = desired - guess;
    
    	for(int i = 0; i < weights.length; i++)
      		weights[i] += c * error * inputs[i];
  	}

}