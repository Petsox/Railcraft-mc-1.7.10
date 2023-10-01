//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\petrk\Desktop\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package buildcraft.api.statements;

import net.minecraftforge.common.util.*;
import net.minecraft.tileentity.*;
import buildcraft.api.core.*;
import net.minecraft.client.renderer.texture.*;
import cpw.mods.fml.relauncher.*;
import java.util.*;

public final class StatementManager
{
    public static Map<String, IStatement> statements;
    public static Map<String, Class<? extends IStatementParameter>> parameters;
    private static List<ITriggerProvider> triggerProviders;
    private static List<IActionProvider> actionProviders;
    
    private StatementManager() {
    }
    
    public static void registerTriggerProvider(final ITriggerProvider provider) {
        if (provider != null && !StatementManager.triggerProviders.contains(provider)) {
            StatementManager.triggerProviders.add(provider);
        }
    }
    
    public static void registerActionProvider(final IActionProvider provider) {
        if (provider != null && !StatementManager.actionProviders.contains(provider)) {
            StatementManager.actionProviders.add(provider);
        }
    }
    
    public static void registerStatement(final IStatement statement) {
        StatementManager.statements.put(statement.getUniqueTag(), statement);
    }
    
    public static void registerParameterClass(final Class<? extends IStatementParameter> param) {
        StatementManager.parameters.put(createParameter(param).getUniqueTag(), param);
    }
    
    @Deprecated
    public static void registerParameterClass(final String name, final Class<? extends IStatementParameter> param) {
        StatementManager.parameters.put(name, param);
    }
    
    public static List<ITriggerExternal> getExternalTriggers(final ForgeDirection side, final TileEntity entity) {
        if (entity instanceof IOverrideDefaultStatements) {
            final List<ITriggerExternal> result = (List<ITriggerExternal>)((IOverrideDefaultStatements)entity).overrideTriggers();
            if (result != null) {
                return result;
            }
        }
        final List<ITriggerExternal> result = new LinkedList<ITriggerExternal>();
        for (final ITriggerProvider provider : StatementManager.triggerProviders) {
            final Collection<ITriggerExternal> toAdd = (Collection<ITriggerExternal>)provider.getExternalTriggers(side, entity);
            if (toAdd != null) {
                for (final ITriggerExternal t : toAdd) {
                    if (!result.contains(t)) {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }
    
    public static List<IActionExternal> getExternalActions(final ForgeDirection side, final TileEntity entity) {
        List<IActionExternal> result = new LinkedList<IActionExternal>();
        if (entity instanceof IOverrideDefaultStatements) {
            result = (List<IActionExternal>)((IOverrideDefaultStatements)entity).overrideActions();
            if (result != null) {
                return result;
            }
            result = new LinkedList<IActionExternal>();
        }
        for (final IActionProvider provider : StatementManager.actionProviders) {
            final Collection<IActionExternal> toAdd = (Collection<IActionExternal>)provider.getExternalActions(side, entity);
            if (toAdd != null) {
                for (final IActionExternal t : toAdd) {
                    if (!result.contains(t)) {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }
    
    public static List<ITriggerInternal> getInternalTriggers(final IStatementContainer container) {
        final List<ITriggerInternal> result = new LinkedList<ITriggerInternal>();
        for (final ITriggerProvider provider : StatementManager.triggerProviders) {
            final Collection<ITriggerInternal> toAdd = (Collection<ITriggerInternal>)provider.getInternalTriggers(container);
            if (toAdd != null) {
                for (final ITriggerInternal t : toAdd) {
                    if (!result.contains(t)) {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }
    
    public static List<IActionInternal> getInternalActions(final IStatementContainer container) {
        final List<IActionInternal> result = new LinkedList<IActionInternal>();
        for (final IActionProvider provider : StatementManager.actionProviders) {
            final Collection<IActionInternal> toAdd = (Collection<IActionInternal>)provider.getInternalActions(container);
            if (toAdd != null) {
                for (final IActionInternal t : toAdd) {
                    if (!result.contains(t)) {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }
    
    public static IStatementParameter createParameter(final String kind) {
        return createParameter(StatementManager.parameters.get(kind));
    }
    
    private static IStatementParameter createParameter(final Class<? extends IStatementParameter> param) {
        try {
            return (IStatementParameter)param.newInstance();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        catch (Error error) {
            BCLog.logErrorAPI((Throwable)error, (Class)IStatementParameter.class);
            throw error;
        }
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerIcons(final IIconRegister register) {
        for (final IStatement statement : StatementManager.statements.values()) {
            statement.registerIcons(register);
        }
        for (final Class<? extends IStatementParameter> parameter : StatementManager.parameters.values()) {
            createParameter(parameter).registerIcons(register);
        }
    }
    
    static {
        StatementManager.statements = new HashMap<String, IStatement>();
        StatementManager.parameters = new HashMap<String, Class<? extends IStatementParameter>>();
        StatementManager.triggerProviders = new LinkedList<ITriggerProvider>();
        StatementManager.actionProviders = new LinkedList<IActionProvider>();
    }
}
