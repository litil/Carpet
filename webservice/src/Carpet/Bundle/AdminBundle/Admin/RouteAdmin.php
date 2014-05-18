<?php
// src/Acme/DemoBundle/Admin/PostAdmin.php

namespace Carpet\Bundle\AdminBundle\Admin;

use Sonata\AdminBundle\Admin\Admin;
use Sonata\AdminBundle\Datagrid\ListMapper;
use Sonata\AdminBundle\Datagrid\DatagridMapper;
use Sonata\AdminBundle\Form\FormMapper;

class RouteAdmin extends Admin
{
    // Fields to be shown on create/edit forms
    protected function configureFormFields(FormMapper $formMapper)
    {
        $formMapper
            ->with('Infos')
                ->add('startName', ['label'=> 'Lieu de départ'])
                ->add('endName', ['label'=> 'Lieu d\'arrivée'])
                ->add('startLat')
                ->add('startLon')
                ->add('endLat')
                ->add('endLon')
                ->add('start')
                ->add('end')
                ->add('distance')
                ->add('duration')
            ->with('Segments')
                ->add('segments', 'sonata_type_collection', [], [
                    'edit' => 'inline',
                    'inline' => 'table',
                    'sortable'  => 'position',
                ]
            )
        ;
    }

    // Fields to be shown on filter forms
    protected function configureDatagridFilters(DatagridMapper $datagridMapper)
    {
        $datagridMapper
            ->add('startName')
            ->add('endName')
            ->add('distance')
            ->add('duration')
        ;
    }

    // Fields to be shown on lists
    protected function configureListFields(ListMapper $listMapper)
    {
        $listMapper
            ->addIdentifier('id')
            ->add('startName')
            ->add('endName')
        ;
    }

    public function getBatchActions()
    {
        // retrieve the default batch actions (currently only delete)
        $actions = parent::getBatchActions();

        if (
          $this->hasRoute('edit') && $this->isGranted('EDIT') &&
          $this->hasRoute('delete') && $this->isGranted('DELETE')
        ) {
            $actions['show'] = array(
                'label' => $this->trans('action_show', array(), 'SonataAdminBundle'),
                'ask_confirmation' => true
            );

        }

        return $actions;
    }
}