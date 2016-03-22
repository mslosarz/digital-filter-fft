package pl.edu.pk.aipsc.digitalfilter.window.event;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import pl.edu.pk.aipsc.digitalfilter.math.*;
import pl.edu.pk.aipsc.digitalfilter.window.SignalGraph;

public class SignalChangeBus extends EventBus {

    private static SignalChangeBus instance;

    private SignalGraph inputSignalGraph;

    private SignalGraph noiseSignalGraph;

    private Function inputFunction;

    private Function noiseFunction;

    private SignalChangeBus() {

    }

    public synchronized static SignalChangeBus getInstance() {
        if (instance == null) {
            instance = new SignalChangeBus();
            instance.register(instance);
        }
        return instance;
    }

    public void setInputSignalGraph(SignalGraph inputSignalGraph) {
        this.inputSignalGraph = inputSignalGraph;
    }

    public void setNoiseSignalPanel(SignalGraph noiseSignalGraph) {
        this.noiseSignalGraph = noiseSignalGraph;
    }

    public void setInputFunction(Function inputFunction) {
        this.inputFunction = inputFunction;
    }

    public void setNoiseFunction(Function noiseFunction) {
        this.noiseFunction = noiseFunction;
    }

    @Subscribe
    public void handleSignalParametersChange(SignalParameters params) {
        Params ox = Params.create(AxisCalculator.calcAxisArray(params.getT0(),
                params.getT1(), params.getDt()));
        if (inputSignalGraph != null) {
            inputSignalGraph.removeAllPlots();
            inputSignalGraph.addLinePlot("s1", ox.getParams(),
                    inputFunction.f(ox).getParams());
        }
        if (noiseSignalGraph != null) {
            noiseSignalGraph.removeAllPlots();
            noiseSignalGraph.addLinePlot("s1", ox.getParams(),
                    noiseFunction.f(ox).getParams());
        }
    }

    @Subscribe
    public void handleFunction(Functions f) {
        this.inputFunction = f;
    }

    @Subscribe
    public void handleFunction(Noises n) {
        this.noiseFunction = n;
    }

    @Subscribe
    public void handleSumFunction(SumFunction sf) {
        if (sf.getF2() instanceof Functions) {
            this.inputFunction = sf;
        } else {
            this.noiseFunction = sf;
        }
    }

}
