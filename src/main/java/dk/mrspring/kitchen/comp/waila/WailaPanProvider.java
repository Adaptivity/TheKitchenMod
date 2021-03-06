package dk.mrspring.kitchen.comp.waila;

import dk.mrspring.kitchen.tileentity.TileEntityPan;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

/**
 * Created by MrSpring on 08-11-2014 for TheKitchenMod.
 */
public class WailaPanProvider implements IWailaDataProvider
{
    @Override
    public ItemStack getWailaStack(IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler)
    {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> strings, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler)
    {
        return null;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> strings, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler)
    {
        TileEntityPan tileEntityPan = (TileEntityPan) iWailaDataAccessor.getTileEntity();
        int cookTime =tileEntityPan.getCookTime();

        if (iWailaConfigHandler.getConfig("show_pan_status"))
            if (cookTime!=0&&cookTime<410)
            {
                String line =StatCollector.translateToLocal("waila.pan_making")+": ";
                String making =tileEntityPan.getIngredient().getLocalizedName();
                line+=making;
                strings.add(line);
            } else if (cookTime>=410)
                strings.add(StatCollector.translateToLocal("waila.pan_done"));

        return strings;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> strings, IWailaDataAccessor iWailaDataAccessor, IWailaConfigHandler iWailaConfigHandler)
    {
        return null;
    }
}
