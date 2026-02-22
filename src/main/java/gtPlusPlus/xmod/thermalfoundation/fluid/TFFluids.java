package gtPlusPlus.xmod.thermalfoundation.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import gtPlusPlus.api.objects.Logger;

public class TFFluids {

    public static Fluid fluidPyrotheum;
    public static Fluid fluidCryotheum;
    public static Fluid fluidEnder;

    public static void preInit() {
        Logger.INFO("Adding in our own versions of Thermal Foundation Fluids - Non-GT");

        fluidPyrotheum = ensureFluid("pyrotheum");
        fluidCryotheum = ensureFluid("cryotheum");
        fluidEnder = ensureFluid("ender");
    }

    private static Fluid ensureFluid(String name) {
        Fluid f = FluidRegistry.getFluid(name);

        if (f == null) {
            Logger.INFO("Fluid '" + name + "' was missing. Registering new fluid.");
            f = new Fluid(name);
            FluidRegistry.registerFluid(f);
        } else {
            Logger.INFO("Fluid '" + name + "' already exists. Using existing instance.");
        }

        return f;
    }

    public static void init() {}

    public static void postInit() {}
}
